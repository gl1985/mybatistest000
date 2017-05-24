package cn.bdqn.tangcco.mapper;

import cn.bdqn.tangcco.entity.Tbuser;

import java.util.List;

/**
 * Created by lei on 2017/5/23.
 */
public interface TbuserMapper {

    public Tbuser login(Tbuser users);
    public int add(Tbuser users);
    public void update(Tbuser users);
    public int delete(int userid);
    public List<Tbuser> queryAll();
    public int count();
    public Tbuser queryById(int userid);
}
