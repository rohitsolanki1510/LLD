package com.chess.launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGameAppDemo {
	Map<String,PieceDummy> peices=new HashMap<>();
	
	public ChessGameAppDemo (){
		peices.put("A", new PieceDummy("Apiece"));
		peices.put("B", new PieceDummy("Bpiece"));
	}
	
	public static void main(String[] args) {
		ChessGameAppDemo obj=new ChessGameAppDemo();
		
		
		List<PieceDummy> pieceDummyForJohn=new ArrayList<>();
		List<PieceDummy> pieceDummyForMayor=new ArrayList<>();
		
		pieceDummyForJohn.addAll(obj.peices.values());
		pieceDummyForMayor.addAll(obj.peices.values());
		
		System.out.println("Before");
		System.out.println("pieceDummyForJohn:"+pieceDummyForJohn);
		System.out.println("pieceDummyForMayor:"+pieceDummyForMayor);
		
		
		pieceDummyForJohn.remove(0);
		
		System.out.println("After");
		System.out.println("pieceDummyForJohn:"+pieceDummyForJohn);
		System.out.println("pieceDummyForMayor:"+pieceDummyForMayor);
		
	}

}
class PieceDummy{
	String name;

	PieceDummy(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PieceDummy [name=" + name + "]";
	}
	
	
	
	
}