package HuellaDeCarbono.Notificacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import org.quartz.*;

public class SchedulerMail {
    private CountDownLatch contadorSincronico = new CountDownLatch(1);


    public static void main(String[] args) throws Exception {
        SchedulerMail schedulerExample = new SchedulerMail();
        schedulerExample.comenzar();
    }


    public void comenzar() throws SchedulerException, InterruptedException {

        // Creacion del scheduler
        SchedulerFactory schedFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = schedFactory.getScheduler();
        scheduler.start();

        //Listener
        scheduler.getListenerManager().addSchedulerListener(new LogSchedulerListenerImpl(scheduler));

        // Construccion de JobDetail
        JobBuilder jobBuilder = JobBuilder.newJob(JobImpl.class);
        JobDataMap data = new JobDataMap();
        data.put("contadorSincronico", contadorSincronico);

        JobDetail jobDetail = jobBuilder
                .withIdentity("Envío de Correo")
                .usingJobData(data)
                .build();

        System.out.println("Hora actual: " + new Date());

        // Formato de expresion cron
        //              seconds ( 0 - 59)
        //   ┌───────────── minute (0 - 59)
        //   │ ┌───────────── hour (0 - 23)
        //   │ │ ┌───────────── day of the month (1 - 31)
        //   │ │ │ ┌───────────── month (1 - 12)
        //   │ │ │ │ ┌───────────── day of the week (0 - 6) (Sunday to Saturday)
        //   │ │ │ │ │ ┌───────────── year
        //   │ │ │ │ │ │
        // * * * * * * *

        //Se envía el primer día de cada mes
        //cron real : 0 0 0 1 * ? *
        //cron de prueba : * * * ? * *  = Todos los segundos
        String cron = "* * * ? * * ";


        // Construccion de Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("Envío rutinario de mail")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        // Asignacion del job y el trigger a la inst de scheduler
        scheduler.scheduleJob(jobDetail, trigger);

        // Para que el proceso principal espere a los calendarizados.
        // Porque en Java cuando el hilo principal muere, todos los sub-hilos también.
        contadorSincronico.await();
        scheduler.shutdown();
    }

}