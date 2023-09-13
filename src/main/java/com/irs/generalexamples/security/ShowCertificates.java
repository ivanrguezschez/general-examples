package com.irs.generalexamples.security;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * Clase que recupera la Clave Privada de un PKCS#12, mostrando tambien la cadena de certificacion.
 * Recibe el nombre del fichero que representa el pkcs12 y su contraseña por linea de comandos
 * Uso: java CertificateInfo <pkcs12_file> <password>
 *
 * @author IRS
 * @version 1.0.0, 09/04/2005
 */
public class ShowCertificates {

    public static void main(String[] args) {
        if (args.length < 2) {
            uso();
        }

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(args[0]), args[1].toCharArray());
            String alias = "";
            String name = null;
            String certName = null;

            for (Enumeration e = keyStore.aliases(); e.hasMoreElements() ;) {
                alias = e.nextElement().toString();
                System.out.println("Alias: " + alias);

                if (keyStore.isCertificateEntry(alias)) {
                    System.out.println("Es una entrada de Certificado");
                    X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
                    // Compruebo si es el de la CA, si es el de la CA paso
                    if (cert.getBasicConstraints() == -1) {
                        System.out.println("El certificado no es de la CA");
                        certName = alias;
                    }
                }

                if (keyStore.isKeyEntry(alias)) {
                    System.out.println("Es una entrada de Clave");
                    name = alias;
                }
            }

            // Recupero la Clave Privada
            PrivateKey privKey = (PrivateKey) keyStore.getKey(alias, args[1].toCharArray());

            Certificate[] certChain = keyStore.getCertificateChain(name);
            System.out.println("Numero de Certificados en la cadena de Certificacion: " + certChain.length);
            for (int i = 0; i < certChain.length; i++) {
                System.out.println("Certificado " + i + " de la cadena de certificacion");
                System.out.println(certChain[i].toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void uso() {
        System.out.println("uso: java ShowCertificates pkcs12_file password");
        System.exit(0);
    }
}
