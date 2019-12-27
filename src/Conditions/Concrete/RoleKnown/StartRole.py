from src.Concepts.Role import Role
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition

class StartRole(PlayerIsRoleCondition):
    """ The Start Role Condition is used when you definitely know the starting role of a person. Use only for starting
    roles not actual roles, e.g. an Executioner can become a Jester. However his starting role was still Executioner and
    not Jester. Also do not use this condition in case someone died and therefore you know his role, because he might
    still be a Disguiser. This condition is mainly used for yourself to put in your own role as game evidence or the
    roles of your Mafia teammate members. """

    def __init__(self, player_id: int, role: Role):
        """ Constructor of the Start Role.

        Arguments:
            player_id (int): The id of the player of which we know his starting role.
            role (Role): The starting role of that player.
        """
        super().__init__(player_id, {role})