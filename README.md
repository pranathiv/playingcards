# Playing Cards

## Contents
1. [Design](#Design)

### Design
Our design has four classes:

1. Card
    * Data Members
       * suit -> int
       * face -> int
    * Methods
       * equals(anotherCard) -> boolean
2. Pack
    * Data Members
        * cards -> List
    * Methods
        * generateAllSuits() -> List(Cards)
        * generateJokers() -> List(Cards)
3. Deck
    * Data Members
        * cards -> List(Cards)
    * Methods
        * add(pack) -> boolean
        * remove(card) -> boolean
        * removeAll(cardOfASuit) -> boolean
        * shuffle -> void
        * cardsLeft -> int
        * deal -> List(Cards)
4. Hand
    * Data Members
      * cards -> List(Cards)
    * Methods
      * add -> boolean
      * remove -> boolean
      * count -> int
