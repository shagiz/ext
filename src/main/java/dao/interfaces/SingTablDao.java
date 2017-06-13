package dao.interfaces;

import entity.SingTabl;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SingTablDao {
    List<SingTabl> findForHeadClue(int headClue);
}
