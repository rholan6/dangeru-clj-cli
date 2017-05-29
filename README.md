# dangeru-test

A command-line board/thread indexer for Danger/u/ using the dangeru-clj api wrapper

## Installation

Download the zip from github, unzip, and you're good to go if you have [Leiningen](https://github.com/technomancy/leiningen)

## Usage

Using Leiningen to index a board:  
`lein run index <boardcode> <limit>`  
  
Using Leiningen to index a thread:  
`lein run thread <boardcode> <limit> <threadID>`  

## Examples

Get the top 5 threads from /u/:
`lein run index u 5`  
  
Get the first 10 posts from thread 147 in /news/:  
`lein run thread news 10 147`

### Bugs

-Apostrophes print as the corresponding html code. Some other characters may do this too, but I've only noticed it for apostrophes.
