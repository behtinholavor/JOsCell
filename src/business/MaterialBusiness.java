package business;

import java.util.ArrayList;
import java.util.List;

import dao.MaterialDao;
import model.Material;

public class MaterialBusiness {
	
	MaterialDao dao = new MaterialDao(); 
	
	public void InserirMaterial(Material material) {		
		if ((material != null) && (material.getMaterial().length() > 0)) {			
			dao.insMaterial(material);		
		}
	}
	
	public void AtualizarMaterial(Material material) {
		if (material != null) {			
			dao.atlMaterial(material);
		}
	}
	
	public void DeletarMaterial(int idmaterial){
		if (idmaterial > 0) {	
			dao.delMaterial(idmaterial);				
		}
	}
	
	public List<Material> ListarMaterial() {		
		return dao.lstMaterial();
	}

	public ArrayList<Object[]> TabelaMaterial() {
		return dao.tblMaterial();
	}
	
	public ArrayList<Object[]> GridMaterial() {
		return dao.grdMaterial();
	}
	
	public Material SetarMaterial(int idmaterial) {
		return idmaterial > 0 ? dao.setMaterial(idmaterial) : null;
	}
	
//	public String[] ColunaMaterial(int idx) {
//		return materialDao.colMaterial(idx);
//	}

}
