from __future__ import annotations
from src.Conditions.Condition import Condition
from src.Concepts.Rolegroup import Rolegroup as RG
from typing import List, TYPE_CHECKING, FrozenSet

if TYPE_CHECKING:
    from src.Mechanics.Gamestate import Gamestate
    from src.Concepts.Role import Role

class AtMostCondition(Condition):
    """ The At Most Condition means that a set of roles should occur at most a given amount of times (n) between the
    players which means that at most n players should have one of the roles in this set of roles.  """

    MAX_AMOUNT_PLAYERS = 15 # The maximum number of players a game can have

    def __init__(self, roles: FrozenSet[Role], amount: int):
        """ Constructor of the At Least Condition.

        Arguments:
            roles (FrozenSet[Role]): The set of roles which should occur at most a given amount of times.
            amount (int): How often these roles should occur at most.
        """
        self.roles = roles
        self.amount = amount

    def valid_skip(self, state: Gamestate):
        return self.__translated_condition(len(state.playerRoles)).valid_skip(state)

    def inner_fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        new_state = state.copy()
        new_state.conditions.insert(0, self.__translated_condition(len(state.playerRoles)))
        return [new_state]

    def opposite(self) -> Condition:
        from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
        return AtLeastCondition(self.roles, self.amount + 1)

    def priority(self) -> float:
        return self.__translated_condition(self.MAX_AMOUNT_PLAYERS).priority()

    def __translated_condition(self, player_amount: int) -> Condition:
        """ Get the corresponding At Least Condition which has the same meaning as this At Most Condition. """
        from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
        converted_roles = RG.NC_ALL.difference(self.roles)
        converted_amount = player_amount - self.amount
        return AtLeastCondition(converted_roles, converted_amount)