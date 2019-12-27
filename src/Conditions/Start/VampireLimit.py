from src.Concepts.Role import Role
from src.Conditions.Abstract.AtMostCondition import AtMostCondition

class VampireLimit(AtMostCondition):
    """ The Vampire Limit limits the number of vampires to 4 (no game can start with more than 4 vampires).
    Reference: https://town-of-salem.fandom.com/wiki/Game_Modes#All_Any (under the All Any section) """

    def __init__(self):
        super().__init__({Role.VAMPIRE}, 4)