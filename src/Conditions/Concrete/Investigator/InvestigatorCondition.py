from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from typing import FrozenSet

from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition


class InvestigatorCondition(ANDCondition):
    """ The Investigator condition is used in the general cases when you retrieve information from some person as
    Investigator. Do not use this condition directly, but use the specific Investigator conditions instead. """

    def __init__(self, player_id: int, roles: FrozenSet[Role], witched: bool = False,
                 amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Investigator condition.

        Arguments:
            player_id (int): The id of the player which we investigated.
            roles (Set[Role]): The roles shown as Investigator result.
            witched (bool): If you as investigator were witched (set to True if you were witched).
            amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        roles = RG.full_include(roles, amnesiacRemembered)
        conditions = [AtLeastCondition(roles, 1)]
        if not witched:
            conditions.append(ORCondition([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                                           PlayerIsRoleCondition(player_id, roles)]))
        super().__init__(conditions)

    def priority(self) -> float:
        return 5.0
