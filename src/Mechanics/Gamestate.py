from __future__ import annotations
from typing import Set, List, Dict, Union
from src.Concepts import Role
from src.Conditions.Condition import Condition
import math

class Gamestate:
    """ A current Gamestate after having set some/all of the player & category roles with the conditions that still
    should be applied on the Gamestate.

    Attributes:
        categoryRoles (List[Set[Role]]): A list of with sets of roles which can still be selected by a player.
        conditions (List[Condition]): The list of conditions which must hold on this Gamestate.
        playerRoles (Dict[int, Union[Set[Role], None]]): A dictionary where the keys are integers representing the
        player id and the values are possible roles which this player still can become. If a value for a given key is
        None then the player haven't yet selected a start category.
        multiplier (int): How often this Gamestate counts (at the end of count_combinations function the result
        will be multiplied by this multiplier value).
    """

    def __init__(self, categoryRoles: List[Set[Role]], conditions: List[Condition],
                 playerRoles: Dict[int, Union[Set[Role], None]], multiplier: int):
        """ Constructor of the Gamestate. Do not call this function! Call the create function if you want to create a
        new Gamestate and call the copy function if you want to copy a Gamestate. """
        self.categoryRoles = categoryRoles
        self.conditions = conditions
        self.playerRoles = playerRoles
        self.multiplier = multiplier

    @staticmethod
    def create(game_modus: List[Set[Role]], condition: Condition) -> Gamestate:
        """ Create a new fresh Gamestate based on a given Gamemodus with a condition that should hold on this Gamestate.

        Arguments:
            game_modus (List[Set[Role]]): The list with set of roles from which the player roles are being sampled.
            condition (Condition): The condition that should hold on this Gamestate.

        Returns:
            The new fresh Gamestate with the given Gamemodus and the condition that should hold.
        """
        playerRoles = dict()
        for i in range(1, len(game_modus) + 1):
            playerRoles[i] = None

        return Gamestate(game_modus, [condition], playerRoles, 1)

    def copy(self) -> Gamestate:
        """ Make a deep copy of this Gamesample object with the first condition removed.

        Returns:
            A copy of this Gamesample object without the first condition.
        """
        cr_copy = [set.copy() for set in self.categoryRoles]
        pr_copy = dict([(key, None if set is None else set.copy()) for key, set in self.playerRoles.items()])
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
        count = math.factorial(len(self.categoryRoles))
        for cr in self.categoryRoles:
            count *= len(cr)
        for pr in self.playerRoles.values():
            if pr is not None:
                count *= len(pr)
        return self.multiplier * count