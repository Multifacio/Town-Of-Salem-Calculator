from src.Concepts.Role import Role
from src.Conditions.Concrete.Investigator.InvestigatorCondition import InvestigatorCondition
from typing import FrozenSet

class DoctorDisguiserSerialKiller(InvestigatorCondition):
    """ The Doctor Disguiser Serial Killer condition is used if someone pops up as Doctor, Disguiser or Serial Killer
    when you investigate that person. """

    def __init__(self, player_id: int, witched: bool = False, amnesiacRemembered: FrozenSet[Role] = None):
        super().__init__(player_id, frozenset({Role.DOCTOR, Role.DISGUISER, Role.SERIALKILLER}), witched,
                         amnesiacRemembered)