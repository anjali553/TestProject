package test.project.TestProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import test.project.TestProject.model.Test_batch;

public interface Test_batchRepository extends JpaRepository<Test_batch, Long>{
	@Query("select count(*) from Test_batch tb where tb.id =:id")
	 Long countTestBatches(@Param("id") Long id);

}
