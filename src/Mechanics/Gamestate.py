from __future__ import annotations
from typing import Set, List, Dict, Union, FrozenSet
from src.Concepts import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Condition import Condition
import math

class Gamestate:
    """ A current Gamestate after having set some/all of the player & category roles with the conditions that still
    should be applied on the Gamestate.

    Attributes:
        categoryRoles (Dict[FrozenSet[Role], int]): A dictionary with sets of roles as key which can still be selected
        by a player and as integer how often it occurs.
        conditions (List[Condition]): The list of conditions which must hold on this Gamestate.
        playerRoles (Dict[int, Union[Set[Role], None]]): A dictionary where the keys are integers representing the
        player id and the values are possible roles which this player still can become. If a value for a given key is
        None then the player haven't yet selected a start category.
        multiplier (int): How often this Gamestate counts (at the end of count_combinations function the result will be
        multiplied by this multiplier value).
    """

    def __init__(self, categoryRoles: Dict[FrozenSet[Role], int], conditions: List[Condition],
                 playerRoles: Dict[int, Union[FrozenSet[Role], None]], multiplier: int):
        """ Constructor of the Gamestate. Do not call this function! Call the create function if you want to create a
        new Gamestate and call the copy function if you want to copy a Gamestate. """
        self.categoryRoles = categoryRoles
        self.conditions = conditions
        self.playerRoles = playerRoles
        self.multiplier = multiplier

    @staticmethod
    def create(game_modus: List[FrozenSet[Role]], condition: Condition) -> Gamestate:
        """ Create a new fresh Gamestate based on a given Gamemodus with a condition that should hold on this Gamestate.

        Arguments:
            game_modus (List[FrozenSet[Role]]): The list with set of roles from which the player roles are being sampled.
            condition (Condition): The condition that should hold on this Gamestate.

        Returns:
            The new fresh Gamestate with the given Gamemodus and the condition that should hold.
        """
        categoryRoles = dict()
        for cr in game_modus:
            cr = frozenset(cr)
            categoryRoles[cr] = categoryRoles.get(cr, 0) + 1

        playerRoles = dict()
        for i in range(1, len(game_modus) + 1):
            playerRoles[i] = None

        return Gamestate(categoryRoles, Gamestate.__decompose_condition(condition), playerRoles, 1)

    @staticmethod
    def __decompose_condition(condition: Condition) -> List[Condition]:
        """ Decompose all AND Conditions and sort the conditions in decreasing priority. """
        decompose_queue = [condition]
        conditions = []
        while decompose_queue:
            condition = decompose_queue.pop()
            if isinstance(condition, ANDCondition):
                decompose_queue.extend(condition.decompose())
            else:
                conditions.append(condition)
        conditions.sort(reverse = True, key = lambda c: c.priority())
        return conditions

    def copy(self) -> Gamestate:
        """ Make a deep copy of this Gamesample object with the first condition removed.

        Returns:
            A copy of this Gamesample object without the first condition.
        """
        cr_copy = self.categoryRoles.copy()
        pr_copy = self.playerRoles.copy()
        con_copy = self.conditions[1:]
        return Gamestate(cr_copy, con_copy, pr_copy, self.multiplier)

    def count_combinations(self) -> int:
        """ Count the number of possible Gamestates (with all values set) given the evidence.

        Returns:
            An integer which represents how many possible Gamestates can be generated given the already filled in
            variables and the evidence.
        """
        if self.conditions:
            cond = self.conditions[0]
            gameStates = cond.fill_evidence(self)
            count = 0
            for gs in gameStates:
                count += gs.count_combinations()
            return count
        else:
            return self.__count_combinations_simple()

    def __count_combinations_simple(self) -> int:
        """ Count the number of possible Gamestates in case there is no more evidence. """
        num_category_roles = 0
        for i in self.categoryRoles.values():
            num_category_roles += i
        count = math.factorial(num_category_roles)
        for cr, amount in self.categoryRoles.items():
            count *= len(cr) ** amount
        for pr in self.playerRoles.values():
            if pr is not None:
                count *= len(pr)
        return self.multiplier * count