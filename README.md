   Relaciones entre tablas:
   
   Socios y Membresías: Un socio puede tener múltiples membresías a lo largo del
        tiempo, pero una membresía está asociada a un solo socio.
        
  Clases y Entrenadores: Una clase está asociada a un entrenador específico, pero un
        entrenador puede impartir múltiples clases.
       
   Socios y Clases: Un socio puede asistir a múltiples clases, y una clase puede tener
        múltiples socios en su asistencia teniendo el cuenta el cupo de la clase. Cada vez que
        un socio asiste a una clase, se deja un registro de la asistencia con fecha actual y se
        actualiza la membresía descontando un pase.
        
   Operaciones CRUD:
        La aplicación debe implementar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
        para todas las entidades (Socios, Entrenadores, Clases, Membresías).
        
   Validación de Datos:
        La aplicación debe incluir validaciones adecuadas para todos los campos de entrada
        (por ejemplo, formatos de texto, longitud, datos requeridos). Asegurarse de que no
        asistan más alumnos para una clase específica, que la capacidad máxima permitida
        de la misma, que no tenga la membresía vencida al momento de registrar asistencia
        del socio y no haya consumido los pases contratados.
        Asegurarse que cuando se asigna un entrenador a una clase, no tenga otra clase en el
        mismo horario.

   #_Asumiremos que una clase se dicta durante toda la semana en el horario
                especificado.
   #_Todas las clases tienen una hora de duración.
