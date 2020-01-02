from src.Concepts.Role import Role
from src.Conditions.Abstract.ANDCondition import ANDCondition
from src.Conditions.Concrete.RoleKnown.StartRole import StartRole
from src.Conditions.Condition import Condition
from src.Conditions.Start.StartCondition import StartCondition
from src.Mechanics.Gamestate import Gamestate
from typing import List, FrozenSet, NamedTuple
import cProfile

Event = NamedTuple("Event", [("name", str), ("condition", Condition)])

class Analyzer:
    """ The Analyzer computes the probability of event in Town of Salem game e.g. claims of players and town hostility
    based on given evidence about that game. """

    def __init__(self, game_modus: List[FrozenSet[Role]], own_id: int, own_role: Role, evidence: Condition,
                 number_players: int = 15):
        """ Constructor of the Analyzer.

        Arguments:
            game_modus (List[FrozenSet[Role]]): A list with set of roles which are the start categories from which the
            roles will be picked and assigned to players.
            own_id (int): Your player id in the Town of Salem game.
            own_role (Role): Your role in the Town of Salem game.
            evidence (Condition): All other evidence about the Town of Salem game, excluding the Start Condition and the
            Start Role condition which encodes as evidence that you have a given role.
            number_player (int): The number of players participating in the Town of Salem game including yourself
            (general games often contain 15 players which is also the maximum for Town of Salem games)
        """
        self.__game_modus = game_modus[:(number_players + 1)]
        self.__evidence = ANDCondition([StartCondition(), StartRole(own_id, own_role), evidence])
        self.__events = []

    def add_event(self, name: str, condition: Condition):
        """ Add an event about the game of which we want to check the likelihood.

        Arguments:
            name (str): The name/identifier for the event (will be used in the print statement)
            condition (Condition): The condition of which we want to check the likelihood.
        """
        self.__events.append(Event(name, condition))

    def compute_likelihoods(self, name: str):
        """ Compute and print all the likelihoods of the events.

        Arguments:
            name (str): The name/identifier of this run (will be used to print the start header of the block)
        """

        # Print the header of this computation run.
        print(name)
        print("".join(["=" for _ in range(2 * len(name))]))

        # Enable a profiler, because likelihood computation of events can take a lot of time to do.
        pr = cProfile.Profile()
        pr.enable()

        # Compute the number of possible combinations given only the evidence.
        gs = Gamestate.create(self.__game_modus, self.__evidence)
        evidence_combinations = gs.count_combinations()

        # Compute the likelihood of every event
        for event in self.__events:
            total_evidence = ANDCondition([event.condition, self.__evidence])
            gs = Gamestate.create(self.__game_modus, total_evidence)
            probability = gs.count_combinations() / evidence_combinations
            print(str(event.name) + ": " + str(probability))

        # Print the results of the profiler
        print()
        print()
        pr.disable()
        pr.print_stats(sort='time')