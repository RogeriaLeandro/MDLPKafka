package br.mil.defesa.interc2.mdlp.MDLPProtocol;

import br.mil.defesa.interc2.mdlp.model.FactoryProtocol;
import br.mil.defesa.interc2.mdlp.model.IProtocol;
import br.mil.defesa.interc2.mdlp.model.MDLP;
import br.mil.defesa.interc2.mdlp.utils.data.FieldsMDLPProtocol;
import br.mil.defesa.interc2.mdlp.utils.data.MDLPDataUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MDLPProtocolTests {

    private Logger logger = Logger.getLogger(MDLPProtocolTests.class.getName());

    @Test
    public void testLibUtil() {
        MDLPDataUnit xpto =new MDLPDataUnit(1);
        assertTrue(xpto.getClass().equals(MDLPDataUnit.class));

    }

    @Test
    public void testMDLPClassExtendsMDLPDataUnit(){
        IProtocol mdlp = FactoryProtocol.createProtocol();
        assertTrue(mdlp.getClass().getSuperclass().equals(br.mil.defesa.interc2.mdlp.utils.data.MDLPDataUnit.class));
    }

    /**
     * Cobertura de Teste do Id do MDLP máximo 7 bits + 1
     * @throws NoSuchFieldException
     */
    @Test
    public void testVerifyTypeOfPrimitiveIdMDLP() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        ((MDLPDataUnit)mdlp).setMdlpId(100);

        var mdlpId = ((MDLPDataUnit)mdlp).getMdlpId();

        assertTrue(((Object)mdlpId).getClass().equals(java.lang.Integer.class));
    }

    @Test
    public void testVerifyValueIdMDLP() {
        IProtocol mdlp = FactoryProtocol.createProtocol();

        ((MDLPDataUnit)mdlp).setMdlpId(100);
        assertTrue(((MDLPDataUnit)mdlp).getMdlpId()==100);
    }

    @Test
    public void testRangeInvalidValueIdMDLP() {
        IProtocol mdlp = FactoryProtocol.createProtocol();

        try{
            ((MDLPDataUnit)mdlp).setMdlpId(150);
            logger.info("FALHOU PORQUE PERMITIU 150 EM VALUE ID MDLP E NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

        try{
            ((MDLPDataUnit)mdlp).setMdlpId(-1);
            logger.info("FALHOU PORQUE PERMITIU -1 EM VALUE ID MDLP");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

    }

    @Test
    public void testVerifySizeIdMDLP() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        ((MDLPDataUnit)mdlp).setMdlpId(100);

        Object idMDLP = ((MDLPDataUnit)mdlp).getMdlpId();
        assertTrue(idMDLP.getClass().equals(java.lang.Short.class));
    }

    //Não entendo o uso de bytes[] em getSystemId
    @Test
    public void testNullableValueSystemId_15000() {

        br.mil.defesa.interc2.mdlp.utils.data.FieldsMDLPProtocol.createSystemId(120);

        // TODO: NOT FOUND USAGE?
        byte[] x = null;
        logger.info ("GETSYSTEMID :" + FieldsMDLPProtocol.getSystemId(x));

        assertTrue( FieldsMDLPProtocol.getSystemId(x)== -15000);
    }

    @Test
    public void testVerifyBlockSize() {

        byte[] x= null;
        br.mil.defesa.interc2.mdlp.utils.data.FieldsMDLPProtocol.getBlockSize(x);
        logger.info("GETBLOCKSIZE: "+ br.mil.defesa.interc2.mdlp.utils.data.FieldsMDLPProtocol.getBlockSize(x));

        //TODO: Exception para FieldsMDLPProtocol conversar sobre exceptions

        assertTrue(FieldsMDLPProtocol.getBlockSize(x)==-15000);
    }

    @Test
    public void testVerifyTypeOfIdSrc() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        ((MDLPDataUnit)mdlp).setSrcId(1);

        var srcId = ((MDLPDataUnit)mdlp).getSrcId();

        assertTrue(((Object)srcId).getClass().equals(java.lang.Integer.class));
    }

    @Test
    public void testVerifyRangeIdSrc() {
        IProtocol mdlp = FactoryProtocol.createProtocol();

        try{
            ((MDLPDataUnit)mdlp).setSrcId(16384);
            logger.info("FALHOU PORQUE PERMITIU 16384 EM VALUE IDSRC E NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

        try{
            ((MDLPDataUnit)mdlp).setMdlpId(-1);
            logger.info("FALHOU PORQUE PERMITIU -1 EM VALUE IDSRC MDLP");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testVerifyTypeOfLongitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        tracks.setLongitude(30000);

        assertTrue(((Object)tracks.getLongitude()).getClass().equals(java.lang.Double.class));
    }

    @Test
    public void testVerifyTypeOfLatitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        tracks.setLatitude(30000);

        assertTrue(((Object)tracks.getLatitude()).getClass().equals(java.lang.Double.class));
    }

    @Test
    public void testVerifyTypeOfAltitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        tracks.setAltitude(100);

        //TODO: Coersar sobre este campo ser short
        assertTrue(((Object)tracks.getAltitude()).getClass().equals(java.lang.Short.class));
    }

    @Test
    public void testVerifyRangeLongitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setLongitude(180d);
            logger.info("FALHOU PORQUE PERMITIU 180,0000 EM VALUE LONGITUDEE NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

        try{
            tracks.setLongitude(-180d);
            logger.info("FALHOU PORQUE PERMITIU -180.0000 EM VALUE LONGITUDE MDLP");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testVerifyRangeLatitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setLatitude(90.0001d);
            logger.info("FALHOU PORQUE PERMITIU 90,0001 EM VALUE LATITUDE NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

        try{
            tracks.setLatitude(-90.0001d);
            logger.info("FALHOU PORQUE PERMITIU -90,0001 EM VALUE LONGITUDE MDLP");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testVerifyRangeAltitude() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setAltitude(55535);
            logger.info("FALHOU PORQUE PERMITIU 55535 EM VALUE ALTITUDE NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

        try{
            tracks.setAltitude(-10001);
            logger.info("FALHOU PORQUE PERMITIU -10001 EM VALUE LONGITUDE MDLP");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void verifyTypeOfIdAcompanhamento() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();
        tracks.setId(100);

        assertTrue(((Object)tracks.getId()).getClass().equals(java.lang.Integer.class));
    }

    @Test
    public void testVerifyRangeIdAcompanhamento() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setId(16384);
            logger.info("FALHOU PORQUE PERMITIU 16384 EM VALUE ID NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }

    }

    @Test
    public void testVerifyTypeOfTimeStamp() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        //TODO: Perguntar como se usar Espec
        //TODO: Como é usado para a conversão xmlgregoriamcard ou somente o uso de now
        tracks.setTimeStamp(1648832798000l);

        assertTrue(((Object)tracks.getTimeStamp()).getClass().equals(java.lang.Long.class));
    }

    @Test
    public void testVerifyTypeOfSpeed() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        tracks.setSpeed(3);

        assertTrue(((Object)tracks.getSpeed()).getClass().equals(java.lang.Double.class));
    }

    @Test
    public void testVerifyRangeOfSpeed() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setSpeed(4.096d);
            logger.info("FALHOU PORQUE PERMITIU 4096 EM VALUE SPEED NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testVerifyTypeOfBearing() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();
        tracks.setBearing(320.2d);

        assertTrue(((Object)tracks.getBearing()).getClass().equals(java.lang.Double.class));
    }

    @Test
    public void testVerifyRangeOfBearing() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();

        try{
            tracks.setBearing(360d);
            logger.info("FALHOU PORQUE PERMITIU 360,0 EM VALUE BEARING NÃO DISPAROU ILLEGALARGUMENTEXCEPTION");
            assertTrue(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testVerifyTypeOfHostility() {
        IProtocol mdlp = FactoryProtocol.createProtocol();
        MDLPDataUnit.Track tracks = ((MDLP)mdlp).get();
        tracks.setHostility(0);

        assertTrue(((Object)tracks.getBearing()).getClass().equals(java.lang.Double.class));
    }
}
