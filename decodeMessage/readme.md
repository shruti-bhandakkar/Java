You're working on a secret team solving coded transmissions.

Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backward! Your colleagues have handed off the last step to you.

Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words in place.

For example:

  char[] message = { 'c', 'a', 'k', 'e', ' ',
                   'p', 'o', 'u', 'n', 'd', ' ',
                   's', 't', 'e', 'a', 'l' };

reverseWords(message);

System.out.println(message);
// prints: "steal pound cake"

When writing your method, assume the message contains only letters and spaces, and all words are separated by one space.

Gotchas
We can do this in O(1)O(1) space. Remember, in place. ↴

We can do this in O(n)O(n) time.

If you're swapping individual words one at a time, consider what happens when the words are different lengths. Isn't each swap O(n)O(n) time in the worst case?

Breakdown
Let’s start with a simpler problem. What if we wanted to reverse all the characters in the message?

Well, we could swap the first character with the last character, then the second character with the second to last character, and so on, moving towards the middle. Can you implement this in code?

Ok, looks good. Does this help us?

Can we use the same concept but apply it to words instead of characters?

Probably. We'll have to figure out a couple things:

How do we figure out where words begin and end?
Once we know the start and end indices of two words, how do we swap those two words?
We could attack either of those first, but I'm already seeing a potential problem in terms of runtime. Can you guess what it is?

What happens when you swap two words that aren't the same length?

Look what happens when we do a character-level reversal:

  // input: the eagle has landed
{ 't', 'h', 'e', ' ', 'e', 'a', 'g', 'l', 'e', ' ',
  'h', 'a', 's', ' ', 'l', 'a', 'n', 'd', 'e', 'd' };

// character-reversed: dednal sah elgae eht
{ 'd', 'e', 'd', 'n', 'a', 'l', ' ', 's', 'a', 'h', ' ',
  'e', 'l', 'g', 'a', 'e', ' ', 'e', 'h', 't' };

  The character reversal reverses the words! It's a great first step. From there, we just have to "unscramble" each word.

 More precisely, we just have to re-reverse each word!
