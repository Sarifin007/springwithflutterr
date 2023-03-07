import 'dart:ffi';
class Task {
  late final int? id;
  late final String? title;
  bool?done;
  Task(
      {
        this.id,
        this.title,
        this.done=false
      }
      );


  factory Task.fromJson(Map<String, dynamic> json) {
    return Task(
        id : json['id'],
        title : json['title'],
        done : json['done'],
    );

  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['title'] = this.title;
    data['done'] = this.done;
    return data;
  }
  void toggle(){
    done=!done!;
  }
}