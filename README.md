# Playing Cards

## Contents
1. [Design](#Design)

### Design
Our design has three main classes:

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
        * deal
4. Hand
    * Data Members
      * cards -> List(Cards)
    * Methods
      * add
      * remove
      * count -> int
