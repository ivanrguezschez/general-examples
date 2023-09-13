package com.irs.generalexamples.security;

import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Set;

/**
 * Clase que muestra los diversos campos y sus valores de un certificado, tanto los básicos como las extensiones del mismo.
 * Recibe el nombre del fichero que representa el certificado por linea de comandos
 * Uso: java CertificateInfo <cert_file>
 *
 * @author IRS
 * @version 1.0.0, 09/04/2005
 */
public class CertificateInfo {

    public static void main(String[] args) {
        if (args.length == 0) {
            uso();
        }

        try {
            // Obtener la Factory de Certificados correcta
            CertificateFactory factory = CertificateFactory.getInstance("X.509");

            // Abro el archivo del certificado
            FileInputStream fis = new FileInputStream(args[0]);

            // Genero un certificado con los datos del fichero
            X509Certificate x509certificate = (X509Certificate) factory.generateCertificate(fis);

            // Primero, imprimo la informacion general del certificado
            System.out.println("---Certificate---");
            System.out.println("type = " + x509certificate.getType());
            System.out.println("version = " + x509certificate.getVersion());
            System.out.println("subject = " + x509certificate.getSubjectDN().getName());
            System.out.println("valid from = " + x509certificate.getNotBefore());
            System.out.println("valid to = " + x509certificate.getNotAfter());
            System.out.println("serial number = " + x509certificate.getSerialNumber().toString(16));
            System.out.println("issuer = " + x509certificate.getIssuerDN().getName());
            System.out.println("signing algorithm = " + x509certificate.getSigAlgName());
            System.out.println("public key algorithm = " + x509certificate.getPublicKey().getAlgorithm());

            // Despues, imprimo la informacion de las extensiones del certificado
            System.out.println("---Critical Extensions---");
            Set setCritical = x509certificate.getCriticalExtensionOIDs();
            if (setCritical != null && setCritical.isEmpty() == false) {
                for (Iterator iterator = setCritical.iterator(); iterator.hasNext(); ) {
                    String oid = (String) iterator.next();
                    System.out.println(oid + "=" + x509certificate.getExtensionValue(oid));
                }
            }

            System.out.println("---NonCritical Extensions---");
            Set setNonCritical = x509certificate.getNonCriticalExtensionOIDs();
            if (setNonCritical != null && setNonCritical.isEmpty() == false) {
                for (Iterator iterator = setNonCritical.iterator(); iterator.hasNext(); ) {
                    String oid = (String) iterator.next();
                    System.out.println(oid + "=" + x509certificate.getExtensionValue(oid));
                }
            }
            System.out.println("---");
            System.out.println(x509certificate);

            // Cierro el archivo.
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void uso() {
        System.out.println("uso: java CertificateInfo cert_file");
        System.exit(0);
    }
}
