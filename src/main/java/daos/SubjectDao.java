package daos;

import java.util.List;

import model.Subject;

public interface SubjectDao {
	public void create (Subject subject);
	public void update (Subject subject);
	public void delete (Integer id);
	public Subject find (Integer id);
	public List<Subject> findAll();
}
