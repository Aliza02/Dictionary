import java.util.*;

public class Hash2 implements Map{
	public Word words[]=new Word[51];
	int size,used;
	private float loadfactor;
	 public class Word
	 {
		 Object word,meaning;
		 
		 Word(Object k,Object v)
		 {
			 word=k;
			 meaning=v;
		 }
		 
	 }
	 public Hash2(int capacity, float lf)
	 {
		 words=new Word[capacity];
		 loadfactor=lf;
	 }
	 public Hash2(int capacity)
	 {
		 this(capacity,0.75F);
		 
	 }
	 public Hash2()
	 {
		 this(101);
	 }
	 public int hash(Object word)
		{
		 if(word==null) throw new IllegalStateException();
			return ((word.hashCode() & 0x7FFFFFFF) % words.length);
		 
		}
	 
	 public Object get(Object word)
		{
		 
		 int h = hash(word);
			for(int i=0;i<words.length;i++) {
				
				int j = nextprob(h,i);
				Word entry = words[j];
				if(entry == null) break;
				if(entry.word.equals(word)) return entry.meaning;
			}
			
			return "Not found";
 	
			
		}
	 
	 public Object key(Object word)
	 {
		 
		 int h = hash(word);
		 for(int i=0;i<words.length; i++) {
			 int j=nextprob(h,i);
			 Word text=words[j];
			 if(text==null) break;
			 if(text.word.equals(word)) return text.word;
		 }
		 return "not found";
	   }
	 
	 public Object put(Object word,Object mean)
	 {
		 if(used>loadfactor*words.length)rehash();
		 int h=hash(word);
		 for(int i=0; i<words.length; i++)
		 {
			 int j=(h+i)%words.length;
				Word entry=words[j];
				if(entry==null)
				{
					words[j]=new Word(word,mean);
					++size;
					++used;
						return null;
				}
		 }
		 
		 throw new IllegalStateException();
		
	 }
	 
	 public int size()
	 {
		 return size;
	 }
	public void rehash()
	{
		Word old[]=words;
		words=new Word[2*old.length+1];
		for(int i=0; i<old.length; i++)
		{
			Word entry=old[i];
			if(entry==null)continue;
			int j=hash(entry.word);
			for(int k=0; k<words.length; k++)
			{
				int x=nextprob(i,j);
				if(words[x]==null)
				{
					words[x]=entry;
					break;
					
				}
			}
		}
		used=size;
		
		
	}
	public int  nextprob(int i, int j)
	{
		return(i+j)%words.length;
	}
	
}
