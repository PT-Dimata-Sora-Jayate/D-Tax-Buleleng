/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.common.entity.logger;

import com.dimata.qdep.entity.Entity;

/**
 *
 * @author dimata005
 */
public interface I_Validasi {
    /**
     * implemen untuk validasi, agar bisa di tambahkan validasi yang dipergunakan
     * @param prevDoc
     * @return 
     */
      public Entity getValidasiDetail(Entity prevDoc); 
}
