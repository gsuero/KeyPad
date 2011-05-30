package com.garis.generator;

public class InvalidPositionException extends Exception {
	private static final long serialVersionUID = -261316052593068746L;
	String mistake;
	  public InvalidPositionException()
	  {
	    super();            
	    mistake = "unknown";
	  }
	  
	  public InvalidPositionException(String err)
	  {
	    super(err);     
	    mistake = err;  
	  }
	  
	  public String getError()
	  {
	    return mistake;
	  }

}
