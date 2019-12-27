from src.Concepts import Role
from src.Conditions.Abstract.PlayerIsRoleCondition import PlayerIsRoleCondition

class StartRole(PlayerIsRoleCondition):
    """ The Start Role Condition is used when you definitely know the starting role of a person. Use only starting
    roles not actual roles, e.g. an Executioner can become a Jester. However his starting role was still Executioner and
    not Jester. Also do not use this condition in case someone died and therefore you know his role, because he might
    still be a Disguiser. This condition is mainly used for yourself to put in your own role as game evidence. """

    def __init__(self, player_id: int, role: Role):
        super().__init__(player_id, {role})