package test.project.TestProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="test_batch")
public class Test_batch implements Serializable{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
    @Column(name="test_batch_name", nullable=false)
	private String TestBatchName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestBatchName() {
		return TestBatchName;
	}

	public void setTestBatchName(String testBatchName) {
		TestBatchName = testBatchName;
	}

	

}
