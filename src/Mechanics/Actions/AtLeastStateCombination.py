from src.Concepts.Role import Role
from src.Conditions.Abstract.AtLeastCondition import AtLeastSelector
from src.Mechanics.Actions.CategoryRoleChange import CategoryRoleChange
from src.Mechanics.Actions.CompositeAction import CompositeAction
from src.Mechanics.Actions.MultiplierChange import MultiplierChange
from src.Mechanics.Actions.PlayerRoleIntersect import PlayerRoleIntersect
from src.Mechanics.Gamestate import Gamestate
from typing import Set, FrozenSet

class AtLeastStateCombination(CompositeAction):
    def __init__(self, at_least_roles: FrozenSet[Role], option: AtLeastSelector, satisfy_amount: int, multiply: int,
                 opposite_roles: FrozenSet[Role]):
        """ Constructor of the At Least State Combination action.

        Arguments:
            at_least_roles (FrozenSet[Role]): The roles which should occur at least an amount of times in the Gamestate.
            option (AtLeastSelector): An option represents a Player Role or Category Role and in case of Category Role
            it also contains how many of these category roles it has.
            satisfy_amount (int): If option is a Player Role then this value is either 0 or 1 where 1 means that this
            option should be a subset of the at_least_roles and 0 means that this option should be disjoint of the
            at_least_roles. If the option is a Category Role then this value indicates how many of this Category Role
            should be a subset of the at_least_roles (and the others should of this Category Role should be disjoint
            of the at_least_roles).
            multiply (int): The Gamestate multiplier gets multiplied by this number.
            opposite_roles (FrozenSet[Role]): The set difference between all roles and the at_least_roles.
        """
        is_player_role, index, max_satisfiable = option
        actions = [MultiplierChange(multiply)]
        self.valid_actions = []
        if is_player_role:
            intersect_roles = at_least_roles if satisfy_amount == 1 else opposite_roles
            action = PlayerRoleIntersect(index, intersect_roles)
            self.valid_actions.append(action)
            actions.append(action)
        else:
            actions.append(CategoryRoleChange(index, -max_satisfiable))
            if satisfy_amount > 0:
                new_roles = index.intersection(at_least_roles)
                self.valid_actions.append(CategoryRoleChange(new_roles, satisfy_amount))
            satisfy_difference = max_satisfiable - satisfy_amount
            if satisfy_difference > 0:
                new_opposite_roles = index.intersection(opposite_roles)
                self.valid_actions.append(CategoryRoleChange(new_opposite_roles, satisfy_difference))
            actions += self.valid_actions

        super().__init__(actions)

    def valid(self, state: Gamestate) -> bool:
        """ Check if this action is valid.

        Arguments:
            state (Gamestate): The Gamestate on which the action is executed.

        Returns:
            True if this action is valid (can be executed) and false otherwise.
        """
        for va in self.valid_actions:
            if not va.valid(state):
                return False
        return True