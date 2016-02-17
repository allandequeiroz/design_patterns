package service;

import lombok.Data;
import lombok.Getter;
import model.Model;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericService<T extends Model<PK>, PK extends Serializable> implements Serializable{

    @Getter
    private final Class<T> type;

    @PersistenceContext
    private EntityManager em;

    protected GenericService(){
        this.type = getGenericClass();
    }

    private Class<T> getGenericClass(){
        Class<T> result = null;
        Type type = this.getClass().getGenericSuperclass();

        if(type instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) type;
            Type[] fieldArgTypes = pt.getActualTypeArguments();
            result = (Class<T>) fieldArgTypes[0];
        }
        return result;
    }

    private Session getSession(){
        return ((Session) em.getDelegate());
    }

    protected Criteria getCriteria(){
        return getSession().createCriteria(type);
    }

    public List<T> findAll(){
        Criteria criteria = getCriteria();
        return criteria.list();
    }

    public T findById(PK pk){
        return em.find(type,pk);
    }

    public void remove(PK pk){
        remove(em.getReference(type,pk));
    }

    public void remove(T obj){
        em.remove(obj);
    }

    public T merge(T ob){
        return em.merge(ob);
    }

    public void refresh(T obj){
        em.refresh(obj);
    }

    public T save(T obj){
        if(obj.getId()==null){
            em.persist(obj);
        }else{
            merge(obj);
        }
        return obj;
    }
}
