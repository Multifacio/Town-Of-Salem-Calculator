from typing import FrozenSet
from src.Concepts.Role import Role
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition
from src.Concepts.Rolegroup import Rolegroup as RG

class ActualRole(PlayerIsRoleCondition):
    """ The Actual Role condition is used when you know someones actual role (which is not starting role). Examples
    when you can use this condition are:
    - Checking if claims made by players are either True or False.
    - If a Mayor has revealed himself, if the Jailor reveals his name in jail or if the Medium has revealed his name
    in the death chat, etc.
    - If the player was brought back to life by a Retributionist (because Disguiser cannot be resurrected).
    - If a person died and you know that he could not be Disguiser, because you know all Mafia members (since you are
    also Mafia), because he died of guilt (Vigilante) or guarding someone (Bodyguard). Or because he died by a Veteran
    and was not a Veteran himself.
    - If a person died and he obviously is the Disguiser, e.g. a Veteran died because he visited a Veteran or a person
    with basic defense being killed by someone with basic attack (SerialKiller being killed by Vigilante/SerialKiller).

    Do not use this condition for regular deaths or situations where it is still possible that the player is a
    Disguiser. Also be careful when using this condition as evidence in case of claims even if the person looks very
    trustworthy, because there is still a chance that the persons could lie. This messes up your final results. """

    def __init__(self, player_id: int, role: Role, amnesiacRemembered: FrozenSet[Role] = None):
        """" Constructor of the Actual Role condition.

        Arguments:
            player_id (int): The id of the player of which the actual role is known.
            role (Role): The actual role of this player.
            amnesiacRemembered (Set[Role]): All the roles remembered by an Amnesiac.
        """
        if amnesiacRemembered is None:
            amnesiacRemembered = frozenset()
        super().__init__(player_id, RG.become_include(frozenset({role}), amnesiacRemembered))