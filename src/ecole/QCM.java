package ecole;

public class QCM extends Examen {
	
	private int numOfQuestions;
	private int nbReponsesCorrectes;
	private static final int bareme = 20;

    public QCM(int numOfQuestions) throws IllegalArgumentException, NullPointerException
	{
	 try
	 {
         if(numOfQuestions == 0)
         {
        	    throw new NullPointerException("Numbers must be over 0");
         }
            this.numOfQuestions = numOfQuestions;
	     }
         catch(IllegalArgumentException e)
         {
        	   throw new IllegalArgumentException("Negative numbers are not allowed"); 
         }
       
	 }
	
	public void setResponsesCorrecte(int nbReponsesCorrectes) throws IllegalArgumentException ,NullPointerException
	{
	 try
	 {
	    if(nbReponsesCorrectes < 0 || nbReponsesCorrectes > 20)
	    {
	    	  throw new IllegalArgumentException("Numbers must be over 0 or 20 and under");
	    }
	      this.nbReponsesCorrectes = nbReponsesCorrectes;
		  this.computeNote();
	 } 
	 catch(NullPointerException e)
     {
     	throw new NullPointerException("Negative numbers are not allowed"); 
     }
		 
    }
	
	private void computeNote()
	{
		 this.note = (double)this.nbReponsesCorrectes / (double)this.numOfQuestions * bareme;
		 setApprieciationNote(this.note);
	}
	
	public void setApprieciationNote(double note) 
	{
	     if (note < 8) 
	     {
	        this.apprieciation = " QCM apprieciation : insufficient";
	     }
	     else if ( note >= 8 && note <= 12 )
	     {
	        this.apprieciation =  " QCM apprieciation : passable ";  
	     } 
	     else if ( note >= 12 && note <= 15 )
	     {
	        this.apprieciation =  " QCM apprieciation : good ";   
	     } 
	     else 
	     {
	        this.apprieciation =  " QCM apprieciation : very good ";  
	     }
	}

}