package com.example.newVersion;

public class Word implements Comparable<Word> {
	   
	String word_target;

	String word_explain;
	
	String definition;
	
	public Word() {
		
	}
	
	public Word(String word_target, String word_explain) {
		
		this.word_target = word_target;
		this.word_explain = word_explain;
	}
	
	
    
	public Word(String word_target, String word_explain, String definition) {
		this.word_target = word_target;
		this.word_explain = word_explain;
		this.definition = definition;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getWord_target() {
		return word_target;
	}

	public void setWord_target(String word_target) {
		this.word_target = word_target;
	}

	public String getWord_explain() {
		return word_explain;
	}

	public void setWord_explain(String word_explain) {
		this.word_explain = word_explain;
	}
    
	@Override
    public String toString() {
        return word_target + "/n" + word_explain + "/n";
    }

    @Override
    public int compareTo(Word o) {
        return 0;
    }
}
