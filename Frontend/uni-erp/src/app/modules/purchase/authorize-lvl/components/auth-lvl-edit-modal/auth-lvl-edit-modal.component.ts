import { AuthorizeLvl } from './../../../../../core/models/Purchase/authorizelvl';
import { Component, OnInit, Input } from '@angular/core';
import { AuthorizeLvlService } from 'src/app/core/services/Purchase/authorize-lvl.service';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthorizeLvlComponent } from '../../authorize-lvl.component';

@Component({
  selector: 'app-auth-lvl-edit-modal',
  templateUrl: './auth-lvl-edit-modal.component.html',
  styleUrls: ['./auth-lvl-edit-modal.component.less']
})
export class AuthLvlEditModalComponent implements OnInit {


	@Input() authLvl: AuthorizeLvl
	constructor(private authLvlService: AuthorizeLvlService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
  }
	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateAuthLvl(){
		this.authLvlService.updateAuthLvl(this.authLvl.id, this.authLvl).subscribe(
			data => {
				this.message.create('success', `Authorize Level Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Authorize Level Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}
}
