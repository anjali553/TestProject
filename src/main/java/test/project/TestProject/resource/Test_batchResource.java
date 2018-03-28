package test.project.TestProject.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.project.TestProject.model.Test_batch;
import test.project.TestProject.repositories.Test_batchRepository;

@RestController
@RequestMapping("/demo")
public class Test_batchResource {
	
	private final Logger log = LoggerFactory.getLogger(Test_batchResource.class);
	
	@Inject
	private Test_batchRepository test_batchRepository;
	
	/**
	 * POST /test_batchs -> Create a new test_batch.
	 */
	@RequestMapping(value = "/test_batch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(HttpServletRequest request, @RequestBody Test_batch test_batch) 
			throws URISyntaxException, Exception{
		log.debug("REST request to save Test_batch : {}", test_batch);
		
		/*if (test_batch.getId() != null) {
			return ResponseEntity
					.badRequest()
					.header("Failure",
							"A new test_batch cannot already have an ID")
					.build();
		}*/
		test_batchRepository.save(test_batch);
		
		return ResponseEntity.created(new URI("/demo/test_batch/" + test_batch.getId())).build();
		
	}
	
	/**
	 * PUT /test_batchs -> Updates an existing test_batch.
	 */
	@RequestMapping(value="/test_batch", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(HttpServletRequest request, @RequestBody Test_batch test_batch)
				throws URISyntaxException, Exception{
		log.debug("REST request to update Test_batch : {}", test_batch);
		/*if (test_batch.getId() == null) {
			return create(request, test_batch);
		}*/
		
		test_batchRepository.save(test_batch);
		return ResponseEntity.ok().build();
		
	}
	
	/**
	 * GET /test_batchs/:id -> get the "id" test_batch.
	 */
	@RequestMapping(value = "/test_batch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Test_batch> get(@PathVariable Long id, HttpServletResponse response) {
		log.debug("REST request to get Test_batch : {}", id);
		Test_batch test_batch = test_batchRepository.findOne(id);
		if (test_batch == null) {
			return new ResponseEntity<Test_batch>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Test_batch>(test_batch, HttpStatus.OK);
	}
	
	/**
	 * DELETE /test_batch/:id -> delete the "id" test_batch.
	 */
	@RequestMapping(value = "/test_batch/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Long id) {
		log.debug("REST request to delete Test_batch : {}", id);
		test_batchRepository.delete(id);
	}
	
	
	/*@RequestMapping(value = "/test_batch/getTestBatchCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TestBatchCountDTO> getTestBatchCount( @Param("testBatchId") Long testBatchId)
			throws Exception {
		
	}*/
}
