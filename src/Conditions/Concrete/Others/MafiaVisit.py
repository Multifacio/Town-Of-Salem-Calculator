from src.Concepts.Role import Role
from src.Concepts.Rolegroup import Rolegroup as RG
from src.Conditions.Abstract.ORCondition import ORCondition
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Conditions.Concrete.ExistenceCondition import ExistenceCondition
from typing import FrozenSet

class MafiaVisit(ORCondition):
    """ The Mafia Visit condition is used when you are Spy and you see the Mafia visiting a player (this condition
    should be used for every player that is visited by the Mafia that you will see as Spy). You should also use this
    condition if a player is killed by the Mafia and cleaned.  """

    # All roles visitable by the Mafia without help of a Transporter or Witch.
    MAFIA_VISITABLE = RG.NC_ALL.difference(RG.NC_MAFIA)

    def __init__(self, player_id: int, amnesiacRemembered: FrozenSet[Role] = None):
        """ Constructor of the Mafia Visit condition.

        Arguments:
            player_id (int): The id of the player that was visited by the Mafia.
            amnesiacRemembered (FrozenSet[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()

        super().__init__([ExistenceCondition(frozenset({Role.TRANSPORTER}), amnesiacRemembered),
                          ExistenceCondition(frozenset({Role.WITCH}), amnesiacRemembered),
                          PlayerIsRoleCondition(player_id, RG.become_include(self.MAFIA_VISITABLE, amnesiacRemembered))])

    def priority(self) -> float:
        return 0.0