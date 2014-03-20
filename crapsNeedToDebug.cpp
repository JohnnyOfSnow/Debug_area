.// Fig. 5.14: fig05_14.c
// Simulating the game of craps.
#include <stdio.h>
#include <stdlib.h>
#include <time.h> // contains prototype for function time

int compareDiceNumber(int sum);
int getstatus(int mypoint ,int gameStatus );
void getresult(int gameStatus);

// enumeration constants represent game status
enum Status { CONTINUE, WON, LOST };

int rollDice( void ); // function prototype

// function main begins program execution
int main( void )
{ 
   int sum; // sum of rolled dice
   int myPoint; // player must make this point to win

   enum Status gameStatus; // can contain CONTINUE, WON, or LOST

   // randomize random number generator using current time
   srand( time( NULL ) );

   sum = rollDice(); // first roll of the dice
   int myStatus = compareDiceNumber(sum);
   // determine game status based on sum of dice
   getresult(myStatus);
   
}
   
int compareDiceNumber(int sum){   
   enum Status { CONTINUE, WON, LOST }; 
   int gameStatus;  
   int myPoint;
   switch( sum ) {
           
      // win on first roll
      case 7: // 7 is a winner
      case 11: // 11 is a winner          
         gameStatus = WON; // game has been won
         myPoint = 0;
         break;

      // lose on first roll
      case 2: // 2 is a loser
      case 3: // 3 is a loser
      case 12: // 12 is a loser
         gameStatus = LOST; // game has been lost
         myPoint = 0;        
         break;

      // remember point
      default:                  
         gameStatus = CONTINUE; // player should keep rolling
         myPoint = sum; // remember the point
         printf( "Point is %d\n", myPoint );
         break; // optional
   } // end switch
   gameStatus = getstatus(myPoint ,gameStatus );
   return gameStatus;
}

int getstatus(int myPoint ,int gameStatus ){
    enum Status { CONTINUE, WON, LOST }; 
   // while game not complete
   while ( CONTINUE == gameStatus ) { // player should keep rolling
      int sum;
      sum = rollDice(); // roll dice again

      // determine game status
      if ( sum == myPoint ) { // win by making point
         gameStatus = WON; // game over, player won
      } // end if
      else {
         if ( 7 == sum ) { // lose by rolling 7
            gameStatus = LOST; // game over, player lost
         } // end if
      } // end else
   } // end while
   return gameStatus;
}   

void getresult(int gameStatus){
      
   // display won or lost message
   if ( WON == gameStatus ) { // did player win?
      puts( "Player wins" );
   } // end if
   else { // player lost
      puts( "Player loses" );
   } // end else
 // end main
}

// roll dice, calculate sum and display results
int rollDice( void )
{
   int die1; // first die
   int die2; // second die
   int workSum; // sum of dice

   die1 = 1 + ( rand() % 6 ); // pick random die1 value
   die2 = 1 + ( rand() % 6 ); // pick random die2 value
   workSum = die1 + die2; // sum die1 and die2

   // display results of this roll
   printf( "Player rolled %d + %d = %d\n", die1, die2, workSum );
   return workSum; // return sum of dice
} // end function rollRice
