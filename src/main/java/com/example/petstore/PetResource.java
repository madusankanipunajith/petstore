package com.example.petstore;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/pets")
@Produces("application/json")
public class PetResource { 
	
	List<Pet> pets = new ArrayList<>();
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	public Response getPets() {
		
		if(pets == null) {
			return Response.ok("Empty ....").build();
		}
		
		return Response.ok(pets).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet found for the id.") })
	@GET
	@Path("find/{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		if (petId < 0) {
			return Response.ok("Negative ID - No Pets Found for this ID").build();
		}
		
//		Pet pet = new Pet();
//		pet.setPetId(petId);
//		pet.setPetAge(3);
//		pet.setPetName("Buula");
//		pet.setPetType("Dog");
		
		List<Pet> myPet = new ArrayList<>();
		
		for(Pet petTemp : pets) {
			if(petTemp.getPetId() == petId) {
				myPet.add(petTemp);
			}
		}
		
		
		return Response.ok(myPet).build();
		
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Add Pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@POST
	@Path("addOne/{id}/{age}/{name}/{type}")
	public Response addPet(@PathParam("id") int id,
						   @PathParam("age") int age,
						   @PathParam("name") String name,
						   @PathParam("type") String type) {
		
		Pet newPet = new Pet();
		newPet.setPetId(id);
		newPet.setPetAge(age);
		newPet.setPetName(name);
		newPet.setPetType(type);
		
		pets.add(newPet);
		
		return Response.ok(newPet).build();
		
	}
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Add Pets Initial", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("initial")
	public Response addInitialPets() {
		
		Pet pet1 = new Pet();
		pet1.setPetId(1);
		pet1.setPetAge(3);
		pet1.setPetName("Boola");
		pet1.setPetType("Dog");

		Pet pet2 = new Pet();
		pet2.setPetId(2);
		pet2.setPetAge(4);
		pet2.setPetName("Sudda");
		pet2.setPetType("Cat");

		Pet pet3 = new Pet();
		pet3.setPetId(3);
		pet3.setPetAge(2);
		pet3.setPetName("Peththappu");
		pet3.setPetType("Bird");
		
		Pet pet4 = new Pet();
		pet4.setPetId(4);
		pet4.setPetAge(2);
		pet4.setPetName("Martin");
		pet4.setPetType("Cat");
		
		Pet pet5 = new Pet();
		pet5.setPetId(5);
		pet5.setPetAge(2);
		pet5.setPetName("Sootin");
		pet5.setPetType("Cat");

		pets.add(pet1);
		pets.add(pet2);
		pets.add(pet4);
		pets.add(pet3);
		pets.add(pet5);
		
		return Response.ok(pets).build();
		
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Find pets", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("{type}")
	public Response findPet( @PathParam("type") String type) {
		List<Pet> result = new ArrayList<>();
		
		String temp = "xxx";
		
		for(Pet pet: pets) {
			
			 temp = pet.getPetType();
			
			if(temp.equals(type)) {
				result.add(pet);
			}
			
			
		}
		
		return Response.ok(result).build();
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Find pets by name", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("findByName/{name}")
	public Response findPetByName( @PathParam("name") String name) {
		List<Pet> result = new ArrayList<>();
		
		String temp = "xxx";
		
		for(Pet pet: pets) {
			
			 temp = pet.getPetName();
			
			if(temp.equals(name)) {
				result.add(pet);
			}
			
			
		}
		
		return Response.ok(result).build();
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Find pets by name", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("findByAge/{age}")
	public Response findPetByAge( @PathParam("age") int age) {
		List<Pet> result = new ArrayList<>();
		
		int temp = 0;
		
		for(Pet pet: pets) {
			
			 temp = pet.getPetAge();
			
			if(temp == age) {
				result.add(pet);
			}
			
			
		}
		
		return Response.ok(result).build();
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete pet by id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@DELETE
	@Path("delete")
	public Response deletePet(@QueryParam("id") int id) {
		if (id < 0) {
			return Response.ok("Negative ID - No Pets Found for this ID").build();
		}
		
		pets.removeIf(pet -> pet.getPetId() == id);
		
		return Response.ok("Deleted succesfully : ID "+ id).build();
	}
	
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "update pet by id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@PUT
	@Path("update")
	public Response updatePet(@QueryParam("id") int id,
							@QueryParam("name") String name,
							@QueryParam("age") int age,
							@QueryParam("type") String type) { 
		
		
		if (id < 0) {
			return Response.ok("Negative ID - No Pets Found for this ID").build();
		}
		
		for(Pet pet: pets) {
			
			if(pet.getPetId() == id) {
				pet.setPetAge(age);
				pet.setPetName(name);
				pet.setPetType(type);
			}
				
		}
		
		
		return Response.ok("Updated succesfully : ID "+ id).build();
		
	}
	
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Find pets by name", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@GET
	@Path("types")
	public Response getTypes() {
		Set<String> petTypes = new HashSet<>();
		
		for(Pet pet : pets) {
			petTypes.add(pet.getPetType());
		}
		
		return Response.ok(petTypes).build();
	}
	
	
	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Delete pet by type", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))) })
	@DELETE
	@Path("delete")
	public Response deletePetUsingType(@QueryParam("type") String type) {
		
		if(type == null) {
			return Response.ok("Empty type").build();
		}
		
		pets.removeIf(pet -> pet.getPetType().equals(type));
		
		return Response.ok("Deleted all pets belongs to the type "+ type).build();
	}
	
}
