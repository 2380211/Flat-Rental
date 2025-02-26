package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.FlatServiceApplication;
import com.example.entity.Flat;
import com.example.exception.FlatNotFoundException;
import com.example.repository.FlatRepository;
import com.example.service.FlatServiceImpl;

@SpringBootTest(classes = FlatServiceApplication.class)
class FlatServiceApplicationTests {

	@Mock
	private FlatRepository flatRepository;

	@InjectMocks
	private FlatServiceImpl flatService;

	private Flat flat;

	@BeforeEach
	public void setUp() {
		flat = new Flat() ;
		flat.setFlatId(2);
		flat.setFlatRent((double) 15000);
		flat.setFlatAddress("123 Main St");
		flat.setStatus("Available");
		flat.setLandlordId(101);
	}

	@Test
	public void testAddFlat() {
		when(flatRepository.save(any(Flat.class))).thenReturn(flat);
		Flat addedFlat = flatService.addFlat(flat);
		assertEquals(flat.getFlatId(), addedFlat.getFlatId());
	}

	@Test
	public void testGetFlat() throws FlatNotFoundException {
		when(flatRepository.findById(flat.getFlatId())).thenReturn(Optional.of(flat));
		Flat foundFlat = flatService.getFlat(flat.getFlatId());
		assertEquals(flat.getFlatId(), foundFlat.getFlatId());
	}

	@Test
	public void testGetFlat_NotFound() {
		when(flatRepository.findById(flat.getFlatId())).thenReturn(Optional.empty());
		assertThrows(FlatNotFoundException.class, () -> flatService.getFlat(flat.getFlatId()));
	}

	@Test
	public void testGetAllFlats() {
		List<Flat> flats = Arrays.asList(flat);
		when(flatRepository.findAll()).thenReturn(flats);
		List<Flat> allFlats = flatService.getAllFlats();
		assertEquals(1, allFlats.size());
		assertEquals(flat.getFlatId(), allFlats.get(0).getFlatId());
	}
	

	@Test
	public void testDeleteFlat() throws FlatNotFoundException {
		when(flatRepository.findById(flat.getFlatId())).thenReturn(Optional.of(flat));
		doNothing().when(flatRepository).deleteById(flat.getFlatId());
		String result = flatService.deleteFlat(flat.getFlatId());
		assertEquals("Flat deleted successfully", result);
	}

	@Test
    public void testGetAllAvailableFlats() {
        when(flatRepository.getAllAvailableFlats()).thenReturn(Arrays.asList(flat));
        List<Flat> availableFlats = flatService.getAllAvailableFlats();
        assertEquals(1, availableFlats.size());
        assertEquals(flat.getFlatId(), availableFlats.get(0).getFlatId());
    }
	
	
	

}
