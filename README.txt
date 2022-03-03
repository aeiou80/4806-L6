
PART 1: the more traditional client-side

    1. Go to "localhost:8080/newaddressbook"
    2. Click the button to create an address book. It will redirect you to a page where you can add buddies to it
    3. Enter the buddies info and click "Add this Buddy"
    4. If you want to create more Address Books click "Create another AddressBook". It will redirect you back to "/newaddressbook"
    5. You can go back to a previously created book by going to "/thisaddressbook/id" where "id" is the book's ID


PART 2: the Single Page Application (SPA) version

    1. Go to "localhost:8080"
    2. Click "Create Address Book". The ID for this new book is shown below "Buddies in this Book:"
    3. Enter some info for a new buddy and click "Add buddy"
    4. If you create more Address Books, you can change the book to add buddies to by typing in the books ID
        below "Choose an Existing Address Book..." and click "Choose this book"
    5. If you entered in a valid book ID, the "id" will change at the bottom of the page and will list
        any buddies that you may have added to it before
