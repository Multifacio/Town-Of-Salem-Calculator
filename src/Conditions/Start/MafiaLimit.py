from src.Conditions.Abstract.AtMostCondition import AtMostCondition
from src.Concepts.Rolegroup import Rolegroup as RG

class MafiaLimit(AtMostCondition):
    """ The Mafia Limit limits the number of Mafia roles to 4 (no game can start with more than 4 mafia members).
    Reference: https://town-of-salem.fandom.com/wiki/Game_Modes#All_Any (under the All Any section) """

    def __init__(self):
        super().__init__(RG.NC_MAFIA, 4)