/**
 * 
 */
package test_dev.paie.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourceH2Config;
import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.repository.AvantageRepository;

/**
 * @author GOBERT Guillaume
 *
 */
@ContextConfiguration(classes = { JpaConfig.class, DataSourceH2Config.class, ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	
	@Autowired private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	//sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		
		avantage.setCode("CA_01");
		avantage.setNom("Gros chèque");
		avantage.setMontant(new BigDecimal(100020.53));
		avantageRepository.save(avantage);
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage findAvantage = avantageRepository.findOne(avantage.getId());
		assertTrue(!findAvantage.equals(null));
	// TODO modifier un avantage
		avantage.setNom("Très gros chèque");
		avantage.setMontant(new BigDecimal(100000009.99));		
		avantageRepository.save(avantage);
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		Avantage findAvantageModif = avantageRepository.findOne(avantage.getId());
		assertEquals(findAvantageModif.getNom(), "Très gros chèque");
		assert new BigDecimal("100000009.99").compareTo(findAvantageModif.getMontant()) == 0;	
		
		Avantage findAvantageCode = avantageRepository.findByCode(avantage.getCode());
		assertTrue(!findAvantageCode.equals(null));
		
		avantageRepository.delete(avantage.getId());
	}
}
