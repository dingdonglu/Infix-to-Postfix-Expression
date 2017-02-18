
public class IntoPost {
	private DynamicArrayStack<Character> theStack; 				// stack to store operator
	private String input; 										// string that store the input
	private String output = "";									// string that store the output
	public IntoPost(String in) {								
	      input = in;											// store string form fill to input
	      theStack = new DynamicArrayStack(input.length());		// assume the stack array's size is the length of input string
	   }
	   public String intoPostfix() {
		   for (int j = 0; j < input.length(); j++) {			// convert string in to char one by one
		     char character = input.charAt(j);
		     
		     if(checkChar(character) ){							// check if the character is valid 
		         if (character=='+'||character=='-'||character=='–'||character=='*'||character=='/'){ 
		        	 checkPrec(character);						// if character is operator it will go to checkPrec to check precedence
		         }else
		         if(character=='('){							// if character is ( will store in to operation stack
		        	 theStack.push(character);
		         }else
		         if(character==')'){							// if character is ) will pop all the operation in the stack
		        	 gotParen(character); 
		         } 
		         
		         else{
		        	 output = output + character; 				// if is not operator the character will add to output string
		         }
		     	}else{											// follow up line 13 if the character is not operation or number and letters throw exception
		     		throw new IllegalArgumentException("the character " + character + " cannot be read !");
		     	}
		    
		    }
		    while (!theStack.isEmpty()) {						// if there is any operator still the the stack add the to string
		         output = output + theStack.pop();
		    }
		      
		      return output; 									//return output
		   }
	   public boolean checkChar(char chr){						// check if the character is valid
		  
		   return(Character.isLetter(chr)||Character.isDigit(chr)||Character.isSpaceChar(chr)||
				   chr=='+'||chr=='-'||chr=='–'||chr=='*'||chr=='/'||chr=='('||chr==')');
			  
	   }
	   public void checkPrec(char operator) {
		      while (!theStack.isEmpty()) {						// check the operation stack
		         char preOp = theStack.pop();					// pop out the previous operation
		         if (preOp == '(') {							// if operator is parenthesis  
		            theStack.push(preOp);						// we store the don't pop operator so we push back the operator
		            break;
		         }
		         else {
		            if (precLevel(preOp) < precLevel(operator)) { 		// compare previous operator level for current operator and previous operator
		               theStack.push(preOp);							// if current operator larger push back the operator because we don't need to pop
		               break;
		            }
				    else
		            output = output + preOp;							// else add the operator to output string
		         }
		      }
		      theStack.push(operator);									// push back the operator if current operator level smaller than previous operator or is not "("
	   }
	   public int precLevel(char op){				// get the precedence's level
		   if (op == '+' || op == '-'|| op =='–'){	// + and - get low precedence level
			   return 1;
		   }else									// else get high precedence level
			   return 2;
	   }
	   public void gotParen(char ch){ 
		   while (!theStack.isEmpty()) {			// every operator that is in the parenthesis')' pop out 
		      char paren = theStack.pop();
		      if (paren == '(') 						// until '('
		      break; 
		      else
		      output = output + paren; 				// and add the output string
		   }
	   }   
		   
 }