package com.example.notificacoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notificacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnotificar_prog = (Button) findViewById(R.id.btnnotificar);
        Button btnnotificar2_prog = (Button) findViewById(R.id.btnnotificar2);

        btnnotificar2_prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "70% de desconto";
                String titulo = "Nova promoção";
                notificarUsuario2(mensagem,titulo);
            }

            private void notificarUsuario2(String mensagem, String titulo) {
                NotificationCompat.Builder notificacao = new NotificationCompat.Builder(getBaseContext());
                notificacao.setContentTitle(titulo);
                notificacao.setContentText(mensagem);
                notificacao.setPriority(Notification.PRIORITY_HIGH);
                notificacao.setSmallIcon(R.drawable.ic_launcher_background);
                notificacao.setAutoCancel(true);

                Intent it = new Intent(getBaseContext(),Promocao2.class);
                PendingIntent pit = PendingIntent.getActivity(getBaseContext(),101,it,PendingIntent.FLAG_CANCEL_CURRENT);
                notificacao.setContentIntent(pit);
                NotificationManager notificar = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
                notificar.notify(9001,notificacao.build());
            }
        });

        btnnotificar_prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "50% de desconto";
                String titulo = "Promoção";
                notificarUsuario(mensagem,titulo);
            }


            //metodo notificar ususario
            //Parametros do tipo texto : Mensagem e titulo
            private void notificarUsuario(String mensagem, String titulo){
                //Objeto 'notificação" para receber os parametros e a estrutura da notificação
                NotificationCompat.Builder notificacao = new NotificationCompat.Builder(getBaseContext());
                //Construindo o titulo da notificação
                notificacao.setContentTitle(titulo);
                //Construindo a mensagem da notificação
                notificacao.setContentText (mensagem);
                //Construindo a prioridade da notificação
                notificacao.setPriority(Notification.PRIORITY_HIGH);
                //Construindo icone da notificação
                notificacao.setSmallIcon(R.drawable.ic_launcher_background);
                //Quando o ususario clicar na notificação, ela será excluída da gaveta de notificações
                notificacao.setAutoCancel(true);
                //Construindo a intenção que chama a activity promoção
                //quando o usuário clicar na mensagem
                Intent it = new Intent(getBaseContext(),Promocao.class);
                //utilizando o PendingIntent para que o Androide Consiga
                //executar a Activity do seu projeto
                PendingIntent pit = PendingIntent.getActivity(getBaseContext(),100,it,PendingIntent.FLAG_CANCEL_CURRENT);
                //Atribuindo na notificação a intentção que será executada quando
                //o usuário clicar na notificação
                notificacao.setContentIntent(pit);
                //Criando o objeot para gerenciar e gerar a notificação no android
                NotificationManager notificar = (NotificationManager) getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);
                //Executando a notificação com o id fixo de 9000
                notificar.notify(9000,notificacao.build());
            }


        });
    }
}