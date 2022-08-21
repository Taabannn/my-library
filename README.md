# my-library
### This is an implementation of the library management system.
<ul>
  <li>The management system contains an array of members and books (also how many are available).</li>
  <li>The attributes of the book are the name and unique identifier.</li>
  <li>The member attributes are name, date of birth, id (which is unique) and array of borrowed books.</li>
</ul>
<h3>The manager controls the library with these commands:</h3>


>      addBook [name] [count]
<b>1-</b> This command adds 'count' numbers of a book with name: 'name' to storage.<br>
(Assume that the maximum number of a books with common name is 50.)<br>

--------------------------------------------------------------------------------------------------------------------------

>      addMember [name] [birth_date]
<b>2-</b> This command adds a member with name: 'name' and birth_date: 'birth_date' to the list of members.<br>
(Assume that the maximum number of a members is 50.)<br>

--------------------------------------------------------------------------------------------------------------------------

>      get [member_id] [book_id]
<b>3-</b> By running this, a book with id: 'book_id' is lent to a member with id: 'member_id'. If the number of borrowed books has reached to maximum 5,

>      MaxReached : [member_name] [member_id]
Above message will be displayed. At least one book must be available and if not, the below message will be shown: 

>      NotAvailable : [book_name] [book_id]
No need to say, but the number of available books and the list of borrowed books will be updated by related command.

--------------------------------------------------------------------------------------------------------------------------

>      return [member_id] [book_id]
<b>4-</b> A member with id: 'member_id' returns a book with id: 'book_id'. 

--------------------------------------------------------------------------------------------------------------------------

>      bookStat
<b>5-</b> By this command, a summary of the status of books with below format will be displayed. 

>      [name1] [id1] [count1]
>      [name2] [id2] [count2]
>      ...

--------------------------------------------------------------------------------------------------------------------------

>      memberStat
<b>6-</b> By this command, a summary of the status of members (contains a list of borrowed books) with below format will be displayed. 

>      [member_name1] [id1] [[book1_name] [book1_id] - [book2_name] [book2_id] - ... ]
>      [member_name2] [id2] [[book1_name] [book1_id] - [book2_name] [book2_id] - ... ]
>      ...

--------------------------------------------------------------------------------------------------------------------------
