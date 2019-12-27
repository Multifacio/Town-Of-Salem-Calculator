from typing import Set, List
from src.Concepts.Role import Role
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Condition import Condition
from src.Mechanics.Gamestate import Gamestate
from src.Concepts.Rolegroup import Rolegroup as RG

class AtMostCondition(Condition):
    """ The At Most Condition means that a set of roles should occur at most a given amount of times (n) between the
    players which means that at most n players should have one of the roles in this set of roles.  """

    def __init__(self, roles: Set[Role], amount: int):
        """ Constructor of the At Least Condition.

        Arguments:
            roles (Set[Role]): The set of roles which should occur at most a given amount of times.
            amount (int): How often these roles should occur at most.
        """
        self.roles = roles
        self.amount = amount

    def fill_evidence(self, state: Gamestate) -> List[Gamestate]:
        # Convert this condition to an At Least Condition and return a game state with that new condition added.
        converted_roles = RG.NC_ALL.difference(self.roles)
        converted_amount = len(state.playerRoles) - self.amount
        new_state = state.copy()
        new_state.conditions.insert(0, AtLeastCondition(converted_roles, converted_amount))
        return [new_state]

    def opposite(self) -> Condition:
        return AtLeastCondition(self.roles, self.amount + 1)