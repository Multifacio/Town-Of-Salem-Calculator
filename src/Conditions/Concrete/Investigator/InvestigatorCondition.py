from src.Concepts.Rolegroup import Rolegroup as RG
from src.Concepts.Role import Role
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.AtLeastCondition import AtLeastCondition
from src.Conditions.Abstract.ANDCondition import ANDCondition
from typing import Set

from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition


class InvestigatorCondition(ANDCondition):
    """ The Investigator condition is used in the general cases when you retrieve information from some person as
    Investigator. Do not use this condition directly, but use the specific Investigator conditions instead. """

    def __init__(self, player_id: int, roles: Set[Role], witched: bool = False, amnesiacRemembered: Set[Role] = None):
        """ Constructor of the Investigator condition.

        Arguments:
            player_id (int): The id of the player which we investigated.
            roles (Set[Role]): The roles shown as Investigator result.
            witched (bool): If you as investigator were witched (set to True if you were witched).
            amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = set()

        roles = RG.full_include(roles, amnesiacRemembered)
        conditions = [AtLeastCondition(roles, 1)]
        if not witched:
            conditions.append(ORCondition([AtLeastCondition({Role.TRANSPORTER}, 1), PlayerIsRoleCondition(player_id, roles)]))

        super().__init__(conditions)