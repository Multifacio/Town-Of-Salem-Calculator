from __future__ import annotations
from dataclasses import dataclass
from typing import Set, List, Dict
from src.Concepts import Role
from src.Conditions.Condition import Condition
import math

@dataclass
class Gamestate:
    """ A current Gamestate after having set some/all of the player & category roles with the conditions that still
    should be applied on the Gamestate.

    Attributes:
        categoryRoles (List[Set[Role]]): A list of with sets of roles which can still be selected by a player.
        conditions (List[Condition]): The list of conditions which must hold on this Gamestate.
        amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        playerRoles (Dict[int, Set[Role]]): A dictionary where the keys are integers representing the player id and
        the values are possible roles which this player still can become. If a value for a given key is None then the
        player haven't yet selected a start category.
    """
    categoryRoles: List[Set[Role]]
    conditions: List[Condition]
    amnesiacRemembered: Set[Role] = None
    playerRoles: Dict[int, Set[Role]] = None

    def __post_init__(self):
        if self.amnesiacRemembered is None:
            self.amnesiacRemembered = set()

        if self.playerRoles is None:
            self.playerRoles = dict()
            for i in range(1, len(self.categoryRoles) + 1):
                self.playerRoles[i] = None

    def copy(self) -> Gamestate:
        """ Make a deep copy of this Gamesample object with the first condition removed.

        Returns:
            A copy of this Gamesample object without the first condition.
        """
        ar_copy = self.amnesiacRemembered.copy()
        cr_copy = [set.copy() for set in self.categoryRoles]
        pr_copy = dict([(key, None if set is None else set.copy()) for key, set in self.playerRoles.items()])
        con_copy = self.conditions[1:]
        return Gamestate(cr_copy, con_copy, ar_copy, pr_copy)

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
        return count


