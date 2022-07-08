package HuellaDeCarbono.Notificacion;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import HuellaDeCarbono.ManejoAmbiental.Organizacion;
import HuellaDeCarbono.Repositorios.RepositorioOrganizaciones;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class JobImpl implements Job {

    private static int count = 0;

    @Override
    public void execute(JobExecutionContext jobContext) throws JobExecutionException {

        List<Miembro> destinatarios = null;
        List<Organizacion> organizaciones = RepositorioOrganizaciones.getRepositorio().getOrganizaciones();
        for (Organizacion organizacion : organizaciones){
            List<Miembro> contactosMail = organizacion.getContactosMail();
            for (Miembro miembro : contactosMail){
                destinatarios.add(miembro);
            }
        }
        JobDetail jobDetail = jobContext.getJobDetail();
        EnviarMail enviarMail = new EnviarMail();
        count++;

        System.out.println("--------------------------------------------------------------------");
        System.out.println("EJECUTANDO JOB " + jobDetail.getKey());
        System.out.println("Ejecucion Num. " + count);
        System.out.println("Inicio: " + jobContext.getFireTime());

        enviarMail.send("tphcgrupo3@gmail.com");
        //for (Miembro destinatario : destinatarios){
        //  enviarMail.send(destinatario.getMail());
        //}

        System.out.println("Fin: " + jobContext.getJobRunTime());
        System.out.println("Proxima ejecucion: " + jobContext.getNextFireTime());
        System.out.println("--------------------------------------------------------------------");

        //for (Miembro destinatario : destinatarios){
          //  enviarMail.send(destinatario.getMail());
        //}

        //aca uso el jobdatamap con mis objetos de negocio
        CountDownLatch contadorSincronico = (CountDownLatch) jobDetail.getJobDataMap().get("contadorSincronico");
        contadorSincronico.countDown();

    }
}