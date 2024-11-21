package edu.pitt.cs;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public interface RentACat {
	public static RentACat createInstance(InstanceType type) {
		switch (type) {
			case IMPL:
				return new RentACatImpl();
			case BUGGY:
				return new RentACatBuggy();
			case SOLUTION:
				return new RentACatSolution();
			case MOCK:
				RentACat mockRentACat = Mockito.mock(RentACat.class);

				Cat mockCat = Mockito.mock(Cat.class);
				when(mockCat.getId()).thenReturn(1);
				when(mockCat.getName()).thenReturn("Jennyanydots");
				when(mockCat.getRented()).thenReturn(false);
				when(mockCat.toString()).thenReturn("ID 1. Jennyanydots");

				List<Cat> cats = new ArrayList<>();
				when(mockRentACat.listCats()).thenAnswer(invocation -> {
					StringBuilder sb = new StringBuilder();
					for (Cat c : cats) {
						sb.append(c.toString()).append("\n");
					}
					return sb.toString();
				});
				when(mockRentACat.returnCat(anyInt())).thenReturn(false);
				when(mockRentACat.rentCat(anyInt())).thenReturn(false);
				when(mockRentACat.renameCat(anyInt(), anyString())).thenReturn(false);
				doNothing().when(mockRentACat).addCat(any(Cat.class));

				return mockRentACat;
			default:
				assert (false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.

	public boolean returnCat(int id);

	public boolean rentCat(int id);

	public boolean renameCat(int id, String name);

	public String listCats();

	public void addCat(Cat c);
}
