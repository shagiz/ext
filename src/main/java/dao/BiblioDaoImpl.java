package dao;

import dao.interfaces.BiblioDao;
import entity.Biblio;

import javax.ejb.Stateless;

@Stateless
public class BiblioDaoImpl extends GenericDaoImpl<Biblio> implements BiblioDao {
}
