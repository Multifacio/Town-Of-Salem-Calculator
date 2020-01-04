# Town Of Salem Calculator
## Introduction
The Town of Salem calculator computes the probability that certain events are true based on information received during the game. This tool can therefore be useful to compute for example the probability that:
- A given role claims is true.
- A player is hostile to town (should be eliminated before town wins).
- A player is Jester or Executioner.

which can be useful for winning more Town of Salem games and analyzing mistakes made in previous Town of Salem games. 

This tool computes the probabilities by counting the number of possible assignment of roles (game states) given the information received during the game (evidence) and given the event being true and divides this by the number of game states given only the evidence. Which is a justified approach if you assume that every possible assignment of roles at the start of the game has an equal likelihood of occuring. The model does not take the behavior of players into account, so always be cautious when using this tool, e.g. active players that reveal roles of evil players are more likely of being a Town member. Also low probability that an event happens does not mean that an event cannot happen. You should always compare probabilities to probabilities of similar events, e.g. if a Sheriff claim has a 0.02 probability of being true and another player claims Bodyguard which also has a 0.02 probability of being true then these claims are not unlikely despite having a low probability of being true. Also keep in mind the limitations of this tool which are described in the 'Limitations' section.

If you want to analyze a given Town of Salem game then you should take a look at the runs folder which contains examples of games that have already been analyzed. Furthermore in the 'Supported Condition' section you can find all conditions that are supported by this tool and how to use them.

## Supported Conditions

## Limitations
- This tool has difficulty with the Vampire role, because the model is based on the start roles of players and not on the actual roles of players. And in case of Vampires the actual roles can be different than the start roles for a lot of roles, because a lot of roles can eventually become a Vampire. The model does not take this into account and therefore if a player turns out to be Vampire then the model also assumes that his starting role was Vampire which can result in contradictions. Thus do not use this tool if you assume/know that the game has started with a Vampire.
- Town of Salem games with a Transporter, Witch or Framer have major impact on the results. For example if the game has a Framer then all the Sheriff suspicion results are ignored and if there is a Witch then all Spy visit results are ignored (because a Mafia member could have visited itself due to a Witch). Even if the player with these roles died. However this tool can still be used if the game contains any of these roles.
- Multiple Amnesiacs are also not supported very well in the sense that if one of the Amnesiacs remembered an hostile role (Mafia, Neutral Killing or Witch) then all Amnesiacs are considered evil even the Amnesiacs that remembered Town roles.
