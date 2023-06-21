package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.VetTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.tecsup.petclinic.mapper.VetMapper;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 */

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class VetControllerTest {

    private static final ObjectMapper om = new ObjectMapper();



	@Autowired
	private MockMvc mockMvc;
	/**
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testFindAllVets() throws Exception {

		//int NRO_RECORD = 73;
		int ID_FIRST_RECORD = 1;

		this.mockMvc.perform(get("/vets"))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				//		    .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
				.andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));
	}
	/**
	 * 
	 * @throws Exception
	 * 
	 */
	/**@Test
	public void testFindVetOK() throws Exception {

		String FIRSTNAME_VET = "James";
		String LASTNAME_VET = "Carter";

		mockMvc.perform(get("/vets/1"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.firstName", is(FIRSTNAME_VET)))
        .andExpect(jsonPath("$.lastName", is(LASTNAME_VET)));
	}

	/**
	 * 
	 * @throws Exception
	 * 
	 */

	@Test

	public void testInsertarVet() throws Exception {

	    String FIRST_NAME = "Helen";
	    String LAST_NAME = "Leary";

	    VetTO newVetTO = new VetTO();
	    newVetTO.setFirstName(FIRST_NAME);
	    newVetTO.setLastName(LAST_NAME);

	    String jsonRequest = om.writeValueAsString(newVetTO);

	    mockMvc.perform(post("/vets")
	            .content(jsonRequest)
	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	            .andExpect(status().isCreated());
	}


	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindVetKO() throws Exception {

	    mockMvc.perform(get("/vets/{id}", 666))
	            .andExpect(status().isNotFound());
	}
	/**
     * 
     * @throws Exception
     */
	 @Test
	    public void testDeleteVet() throws Exception {
	        String FIRST_NAME = "Helen";
	        String LAST_NAME = "Leary";

	        VetTO newVetTO = new VetTO();
	        newVetTO.setFirstName(FIRST_NAME);
	        newVetTO.setLastName(LAST_NAME);

	        ResultActions result = mockMvc.perform(post("/vets")
	                .content(om.writeValueAsString(newVetTO))
	                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	                .andDo(print())
	                .andExpect(status().isCreated());

	        String response = result.andReturn().getResponse().getContentAsString();
	        int vetId = JsonPath.parse(response).read("$.id");

	        mockMvc.perform(delete("/vets/{id}", vetId))
	                .andDo(print())
	                .andExpect(status().isOk());

	        mockMvc.perform(get("/vets/{id}", vetId))
	                .andExpect(status().isNotFound());
	    }
}
	/**@Test
	public void testUpdateVet() throws Exception {
        String FIRST_NAME = "Henry";
        String LAST_NAME = "Stevens";
        VetTO newVetTO = new VetTO();
        newVetTO.setFirstName(FIRST_NAME);
        newVetTO.setLastName(LAST_NAME);
        ResultActions result = mockMvc.perform(post("/vets")
                .content(om.writeValueAsString(newVetTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated());
        Integer vetId = JsonPath.parse(result.andReturn().getResponse().getContentAsString()).read("$.id");
        String vetIdString = vetId.toString();
        String updatedFirstName = "John";
        String updatedLastName = "Doe";
        VetTO updatedVetTO = new VetTO();
        updatedVetTO.setFirstName(updatedFirstName);
        updatedVetTO.setLastName(updatedLastName);
        mockMvc.perform(put("/vets/{id}", vetId)
                .content(om.writeValueAsString(updatedVetTO))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(vetId))))
                .andExpect(jsonPath("$.firstName", is(updatedFirstName)))
                .andExpect(jsonPath("$.lastName", is(updatedLastName)));
    }
}
**/



