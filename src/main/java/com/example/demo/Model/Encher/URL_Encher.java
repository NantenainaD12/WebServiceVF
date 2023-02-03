package com.example.demo.Model.Encher;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/encher")
public class URL_Encher {

    ////GET CURRENT ENCHER Done
    @GetMapping("/get_all_current")
    public List<Encher> get_all_current() {
        return Encher.get_current_encher();
    }

    ////GET ENCHER BY ID Done
    @PostMapping("/get_encher_by_id")
    public List<Encher> get_encher_by_id(@Validated @RequestBody String id) {
        System.out.println("get_encher_by_id"+id);
        List<Encher> val=new ArrayList<>();
        val.add(Encher.get_by_id(id));
        return val;
    }
    ////Encherir
    @PostMapping("/encherir")
    public boolean encherir(@Validated @RequestBody Tout_encherir p)throws Exception{
        System.out.println("dtay="+p.getDaty_encherir()+" id_encherri "+p.getId_encherir()+" id_C "+p.getId_encher()+" nom "+p.getNom()+" id_ench= "+p.getId_encher()+" momt= "+p.getMontant());
        return p.encherir();
    }
    ////GET VALINY RECHERCHE Done
    @PostMapping("/recherche")
    public List<Encher> recherche(@Validated @RequestBody String id) {
        System.out.println("recherche");return Encher.recherche(id);
    }
  ////GET MY PROPRE ENCHER Done
  @PostMapping("/my_propre_encher/{id}")
  public List<Encher> my_propre_encher(@PathVariable String id)throws Exception{
      return Encher.my_propre_encher(id);
  }
    ////GET MY PROPRE ENCHER Done
    @PostMapping("/my_propre_encher")
    public List<Encher> my_propre_encher(@Validated @RequestBody Client p)throws Exception{
        return Encher.my_propre_encher(p.getId_client());
    }


    ////insert Encher Done
    @PostMapping("/insert_encher")
    public boolean insert(@Validated @RequestBody Encher p)throws Exception{
        return p.insert_encher();
    }

    ////insert Rechargent
    @PostMapping("/rechargement")
    public boolean insert_rechargement(@Validated @RequestBody Rechargement p)throws Exception{
        return p.insert();
    }


    ////insert Client Done
    @PostMapping("/insert_client")
    public boolean insert(@Validated @RequestBody Client p)throws Exception{
        return p.insert();
    }

    ////LOGIN Done
    @PostMapping("/login")
    public Client login(@Validated @RequestBody Client p){
        return Client.login(p.getLogin(),p.getMdp());
    }

    @GetMapping("/listes/{id}")
    public Vector<RechargementList> getAllUser(@PathVariable int id) throws Exception {
        return RechargementList.getAll(id);
    }

    @GetMapping("/categories")
    public Vector<Categories>getAll() throws Exception {
        return Categories.listAll();
    }

}
